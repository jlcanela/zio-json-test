import mill._, scalalib._

object ziojson extends ScalaModule {

  val ZioVersion        = "2.0.0-RC1"
  val ZioJsonVersion    = "0.3.0-RC2"
  val ZioHttpVersion    = "2.0.0-RC2"
  // def scalaVersion = "3.1.0"
  def scalaVersion = "2.13.8"

  def ivyDeps = Agg(
    ivy"dev.zio::zio::${ZioVersion}",
    ivy"dev.zio::zio-json:${ZioJsonVersion}",
    ivy"io.d11::zhttp:${ZioHttpVersion}",
  )

  override def mainClass = T { Some("App") }

  val a = 1
}
