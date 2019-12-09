// #Sireum

package HA.HomeAutomation

import org.sireum._
import art._
import HA._

// This file was auto-generated.  Do not edit

@record class TemperatureSensor_Step_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,

  Temp_in: Port[HomeAutomation.Temperature],
  Temp_out: Port[HomeAutomation.Temperature]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Temp_in,
              Temp_out),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(Temp_in,
                   Temp_out),

    eventOuts = ISZ()
  )

  val api : TemperatureSensor_Step_impl_Bridge.Api =
    TemperatureSensor_Step_impl_Bridge.Api(
      id,
      Temp_in.id,
      Temp_out.id
    )

  val entryPoints : Bridge.EntryPoints =
    TemperatureSensor_Step_impl_Bridge.EntryPoints(
      id,

      Temp_in.id,
      Temp_out.id,

      TemperatureSensor_Step_impl_Impl(api)
    )
}

object TemperatureSensor_Step_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    Temp_in_Id : Art.PortId,
    Temp_out_Id : Art.PortId) {

    def getTemp_in() : Option[HomeAutomation.Temperature] = {
      val value : Option[HomeAutomation.Temperature] = Art.getValue(Temp_in_Id) match {
        case Some(HomeAutomation.Temperature_Payload(v)) => Some(v)
        case _ => None[HomeAutomation.Temperature]()
      }
      return value
    }

    def getTemp_out() : Option[HomeAutomation.Temperature] = {
      val value : Option[HomeAutomation.Temperature] = Art.getValue(Temp_out_Id) match {
        case Some(HomeAutomation.Temperature_Payload(v)) => Some(v)
        case _ => None[HomeAutomation.Temperature]()
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
    TemperatureSensor_Step_impl_BridgeId : Art.BridgeId,

    Temp_in_Id : Art.PortId,
    Temp_out_Id : Art.PortId,

    component : TemperatureSensor_Step_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Temp_in_Id,
                                              Temp_out_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

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