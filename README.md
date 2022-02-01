# ZIO & ZIO-JSON

## Magnolia cannot infor Map[MetricKey, MetricState]
Sample repository to create a decoder:
```scala
 implicit val codec: JsonCodec[Map[MetricKey, MetricState]] = DeriveJsonCodec.gen[Map[MetricKey, MetricState]]
```
The previous code fails with "magnolia: could not infer DeriveJsonEncoder.Typeclass for type Map[zio.metrics.MetricKey,zio.metrics.MetricState]"

## Issue with zio-metric ?

It seems it’s not possible to derive JsonEncoder[Map[zio.ZIOMetric[_],String]]
 


```bash
./mill ziojson.run
```

```
[error] /home/jlcanela/dev/github.com/jlcanela/zio-json-test/ziojson/src/App.scala:25:23: could not find implicit value for parameter encoder: zio.json.JsonEncoder[Map[zio.ZIOMetric[_],String]]
[error]         println(json2.toJson)
```

