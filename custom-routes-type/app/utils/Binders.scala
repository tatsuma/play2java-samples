package utils

import play.api.mvc.PathBindable
import java.math.BigInteger

object Binders {
  implicit def bigIntegerPathBinder = new PathBindable[BigInteger] {
    override def bind(key: String, value: String): Either[String, BigInteger] = {
      Right(new BigInteger(value))
    }
    override def unbind(key: String, value: BigInteger): String = {
      value.toString
    }
  }
}