// #Sireum

package HA.HomeAutomation

import org.sireum._
import art._
import HA._

// This file was auto-generated.  Do not edit

@record class Thermostat_Step_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,

  TermostatCmd: Port[HomeAutomation.TermostatCMD.Type],
  TermostatAct: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(TermostatCmd,
              TermostatAct),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(TermostatCmd),

    eventOuts = ISZ(TermostatAct)
  )

  val api : Thermostat_Step_impl_Bridge.Api =
    Thermostat_Step_impl_Bridge.Api(
      id,
      TermostatCmd.id,
      TermostatAct.id
    )

  val entryPoints : Bridge.EntryPoints =
    Thermostat_Step_impl_Bridge.EntryPoints(
      id,

      TermostatCmd.id,
      TermostatAct.id,

      Thermostat_Step_impl_Impl(api)
    )
}

object Thermostat_Step_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    TermostatCmd_Id : Art.PortId,
    TermostatAct_Id : Art.PortId) {

    def getTermostatCmd() : Option[HomeAutomation.TermostatCMD.Type] = {
      val value : Option[HomeAutomation.TermostatCMD.Type] = Art.getValue(TermostatCmd_Id) match {
        case Some(HomeAutomation.TermostatCMD_Payload(v)) => Some(v)
        case _ => None[HomeAutomation.TermostatCMD.Type]()
      }
      return value
    }

    def sendTermostatAct() : Unit = {
      Art.putValue(TermostatAct_Id, art.Empty())
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
    Thermostat_Step_impl_BridgeId : Art.BridgeId,

    TermostatCmd_Id : Art.PortId,
    TermostatAct_Id : Art.PortId,

    component : Thermostat_Step_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(TermostatCmd_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(TermostatAct_Id)

    def compute(): Unit = {
      val EventTriggered(portIds) = Art.dispatchStatus(Thermostat_Step_impl_BridgeId)
      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- portIds) {

        if(portId == TermostatCmd_Id){
          val Some(HomeAutomation.TermostatCMD_Payload(value)) = Art.getValue(TermostatCmd_Id)
          component.handleTermostatCmd(value)
        }
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