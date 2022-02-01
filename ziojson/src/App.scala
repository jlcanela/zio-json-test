import zio._
import zio.json._
import zio.metrics._
import zhttp.http._

object App {

    implicit val codecLabel: JsonCodec[MetricLabel] = DeriveJsonCodec.gen[MetricLabel]
    implicit val codecBoundaries: JsonCodec[ZIOMetric.Histogram.Boundaries] = DeriveJsonCodec.gen[ZIOMetric.Histogram.Boundaries]
    implicit val codecKey: JsonCodec[MetricKey] = DeriveJsonCodec.gen[MetricKey]
    implicit val codecType: JsonCodec[MetricType] = DeriveJsonCodec.gen[MetricType]
    implicit val codecState: JsonCodec[MetricState] = DeriveJsonCodec.gen[MetricState]

    // unable to compile DeriveJsonCodec.gen[Map[(MetricKey, MetricState)]]
    // "magnolia: could not infer DeriveJsonEncoder.Typeclass for type Map[zio.metrics.MetricKey,zio.metrics.MetricState]"
    
    
    def main(args: Array[String]) = {
        val aMetricKey = MetricKey.Counter("count")
        
        val json = Map("key" -> "value").toJson
        println(json)
        
        // No need to create codecList
        // implicit val codecList: JsonCodec[List[(MetricKey, MetricState)]] = DeriveJsonCodec.gen[List[(MetricKey, MetricState)]]
        val jsonList: List[(MetricKey, String)] = List(aMetricKey -> "value")
        println(jsonList.toJson)
        
        // a test suggested by Rob, looks good
        val _ = implicitly[JsonCodec[MetricKey]]

        // codecMap cause the following error
        // magnolia: could not infer DeriveJsonEncoder.Typeclass for type Map[zio.metrics.MetricKey,zio.metrics.MetricState]
        // implicit val codecMap: JsonCodec[Map[MetricKey, MetricState]] = DeriveJsonCodec.gen[Map[MetricKey, MetricState]]
        val jsonMap: Map[MetricKey, String] = Map(aMetricKey -> "value")
        // and cannot find the following encoder
        println(jsonMap.toJson)

    }
}