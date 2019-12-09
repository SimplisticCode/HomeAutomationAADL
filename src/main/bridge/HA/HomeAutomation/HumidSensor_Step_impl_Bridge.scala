// #Sireum

package HA.HomeAutomation

import org.sireum._
import art._
import HA._

// This file was auto-generated.  Do not edit

@record class HumidSensor_Step_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,

  Humid_out: Port[HomeAutomation.Humidity],
  Humid_in: Port[HomeAutomation.Humidity]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Humid_out,
              Humid_in),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(Humid_in),

    eventOuts = ISZ(Humid_out)
  )

  val api : HumidSensor_Step_impl_Bridge.Api =
    HumidSensor_Step_impl_Bridge.Api(
      id,
      Humid_out.id,
      Humid_in.id
    )

  val entryPoints : Bridge.EntryPoints =
    HumidSensor_Step_impl_Bridge.EntryPoints(
      id,

      Humid_out.id,
      Humid_in.id,

      HumidSensor_Step_impl_Impl(api)
    )
}

object HumidSensor_Step_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    Humid_out_Id : Art.PortId,
    Humid_in_Id : Art.PortId) {

    def sendHumid_out(value : HomeAutomation.Humidity) : Unit = {
      Art.putValue(Humid_out_Id, HomeAutomation.Humidity_Payload(value))
    }

    def getHumid_in() : Option[HomeAutomation.Humidity] = {
      val value : Option[HomeAutomation.Humidity] = Art.getValue(Humid_in_Id) match {
        case Some(HomeAutomation.Humidity_Payload(v)) => Some(v)
        case _ => None[HomeAutomation.Humidity]()
      }
      return value
    }


    def logInfo(msg: String): Unit = {
      Art.logInfo(id, msg)
    }

    def logDebug(msg: String): Unit = {
      Art.logDebug(id, msg)
    }

    def logError(msg: String): Unit = {
      Art.logError(id, msg)
    }
  }

  @record class EntryPoints(
    HumidSensor_Step_impl_BridgeId : Art.BridgeId,

    Humid_out_Id : Art.PortId,
    Humid_in_Id : Art.PortId,

    component : HumidSensor_Step_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Humid_in_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Humid_out_Id)

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.timeTriggered()
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate: Unit = {
      component.activate()
    }

    def deactivate: Unit = {
      component.deactivate()
    }

    def finalise: Unit = {
      component.finalise()
    }

    def initialise: Unit = {
      component.initialise()
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def recover: Unit = {
      component.recover()
    }
  }
}