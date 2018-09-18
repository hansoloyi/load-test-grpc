FROM hseeberger/scala-sbt

WORKDIR /opt/app

COPY target/scala-*/grpc-scala-assembly-*.jar /opt/app/jar/grpc-scala-assembly.jar

RUN chmod 700 /opt/app/jar/grpc-scala-assembly.jar

CMD ["java", "-jar", "/opt/app/jar/grpc-scala-assembly.jar"]