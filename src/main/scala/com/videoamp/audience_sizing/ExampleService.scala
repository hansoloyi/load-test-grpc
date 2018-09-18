package com.videoamp.audience_sizing

import com.videoamp.library.audience_sizing.AudienceSizesServiceGrpc.AudienceSizesService
import com.videoamp.library.audience_sizing.{AudienceSizes, PostAudienceSizesParams}

import scala.concurrent.Future


class ExampleService extends AudienceSizesService {

  override def postAudienceSizes(request: PostAudienceSizesParams): Future[AudienceSizes] = ???

}
