// #Sireum

package HA.HomeAutomation

import org.sireum._
import art._
import HA._

// This file was auto-generated.  Do not edit

@record class Environment_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,

  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val api : Environment_impl_Bridge.Api =
    Environment_impl_Bridge.Api(
      id,
    )

  val entryPoints : Bridge.EntryPoints =
    Environment_impl_Bridge.EntryPoints(
      id,

      ,

      Environment_impl_Impl(api)
    )
}

object Environment_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    ) {



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
    Environment_impl_BridgeId : Art.BridgeId,

    ,

    component : Environment_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

    def compute(): Unit = {
      val EventTriggered(portIds) = Art.dispatchStatus(Environment_impl_BridgeId)
      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- portIds) {

      }

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