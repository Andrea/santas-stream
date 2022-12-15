package com.northpole.santas

import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.circe.CirceEntityCodec.circeEntityEncoder
import org.http4s.dsl.io._

object SantasRoutes {

  def ledger(consignmentService: ConsignmentService): HttpRoutes[IO] = {
    HttpRoutes.of[IO] { case GET -> Root / "list" / lastName / firstName =>
      Ok(
        consignmentService.getConsignment(FullName(firstName, lastName))
      )
    }
  }
}
