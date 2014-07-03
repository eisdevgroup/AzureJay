package ru.eis.azurejay

import play.api.libs.json.{Json, JsObject, JsValue}
import play.api.libs.ws._
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
 * User: esypachev
 * Date: 01.07.14
 * Time: 16:23
 */
class AzureJayAdapter(serviceName: String, tableName: String) {

  private val serviceUrl: String = s"https://$serviceName.azure-mobile.net/tables/$tableName"
  private val headers: Seq[(String,String)] = Seq(("Accept", "application/json"), ("Content-Type", "application/json"))

  def query() : Future[Response] =
    WS.url(serviceUrl).withHeaders(headers:_*).get()

  def create(message: Message) : Future[Response] =
    WS.url(serviceUrl).withHeaders(headers:_*).post(message.toJson)

  def update(id: String, message: Message) : Future[Response] =
    WS.url(s"${serviceUrl}/${id}").withHeaders(headers:_*).put(message.toJson)

  def delete(id: String) : Future[Response] =
    WS.url(s"${serviceUrl}/${id}").withHeaders(headers:_*).delete()

}

case class Message(data: Map[String, String], deviceUid: String, deviceType: DeviceType.Type) {
  private val jsDeviceUid = "channel"
  private val jsDeviceType = "deviseType"

  def toJson: JsValue = {
    val dataMap = Map(
      jsDeviceUid  -> deviceUid,
      jsDeviceType -> deviceType.toString
    ) ++ data
    Json.toJson(dataMap)
  }
}

object DeviceType extends Enumeration {
  type Type = Value
  val Android, iOS, WindowsPhone = Value
}




