package com.videoamp.audience_sizing

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

import com.videoamp.enums.ProcessStatus
import com.videoamp.linear_planner.runs.{PostRunStatusParams, RunServiceGrpc, RunStatus}
import io.grpc.ManagedChannelBuilder
import io.kubernetes.client.Configuration
import io.kubernetes.client.apis.{BatchV1Api, CoreV1Api}
import io.kubernetes.client.custom.Quantity
import io.kubernetes.client.models._
import io.kubernetes.client.util.Config

import scala.util.{Failure, Success}

object ExampleServer {

  //dc312453-0400-4f08-9048-b3ef51b04202 prod
  //efe67b3a-2af9-43dd-90a6-1017763acb89 stage
  def doit(m: Int): Unit = {
    def t = {
      val channel = ManagedChannelBuilder.forTarget("cleanroom-linear-planner.prod.dc3").usePlaintext(true).build
      val ts = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now)
      val Rstatus = RunStatus(status = ProcessStatus.PROCESSING, timestamp = ts)

      val request = PostRunStatusParams(
        runUuid = "dc312453-0400-4f08-9048-b3ef51b04202", //a8795325-7d8e-4e93-a1b7-7df317b18b37 stage cc3b2816-9609-4294-a207-ac6a80e77e85
        runStatus = Option(Rstatus)
      )

      val reply = RunServiceGrpc.blockingStub(channel).postRunStatus(request)
      channel.shutdown
      println(reply.id)
    }

    //  if (m >= 1) doit(m-1) else println("errored")

    try {
      t
    } catch {
      case ex: Exception => println(ex.printStackTrace)
    }
  }

  def main(args: Array[String]): Unit = {

    Vector.range(0, 20).par.foreach { s =>
      doit(3)
    }

  }

}
