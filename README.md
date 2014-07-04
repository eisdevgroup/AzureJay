# AzureJay

Play plugin for integration with Mobile Service in Microsoft Azure cloud.

## Installation

Plugin currentlu support only play 2.2.3

To install it:

* add resolver to your resolver list in ```build.sbt``` or ```project/Build.scala```

    resolvers += "EIS Articactory Realm" at "http://artifactory.eis.ru/artifactory/libs-release-local/"

* add dependency to your dependency list in ```build.sbt``` or ```project/Build.scala```

    "ru.eis" %% "azurejay" % "0.1"

* add initialization to your plugin config ```conf/play.plugins```

    1800:ru.eis.azurejay.AzureJayPlugin

* configure plugin in application config file ```conf/application.conf```

    azure.service=testservice
    azure.table=TodoItems

## Usage from Scala

```scala
import ru.eis.azurejay._

// get plugin instance
val notifier = use[AzureJay].sender
// create message
val message = Message(Map("hello" -> "world"), "deviseuid", DeviceType.Android)
// get azure service content
notifier.query()
// create new row in azure service
notifier.create(message)
// update row
notifier.update("somelongidofarow", message)
// delete row
notifier.delete("somelongidofarow")
```

plugin requires several implicits in the scope, don't forget to add them:

```scala
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global
```

## Limitations

* plugin currently support only Play 2.2.3
* plugin currently support only Scala 2.10
* plugin currently support only one table in MS Azure mobile service


