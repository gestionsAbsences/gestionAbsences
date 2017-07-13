import React, { Component } from 'react';

class Menu extends Component {

  constructor (props) {
    super(props); // Récupère le Props du parent
    this.props=props;
  }

  trtMenu = () => {
    let res;
    if ((this.props.role & 4)===4) {
      res=<div className="panel panel-default">
        <div className="panel-heading">
          <a data-toggle="collapse" data-parent="#accordion" href={"#collapse3"+this.props.cas}>
            <h4 className="panel-title">
              <span className="glyphicon glyphicon-file"></span> Gestion
            </h4>
          </a>
        </div>
        <div id={"collapse3"+this.props.cas} className="panel-collapse collapse">
          <div className="panel-body">
            <table className="table">
              <tbody>
                {this.trtSousMenu("Gestion du personnel", "/gestionpersonnel", 4)}
                {this.trtSousMenu("Gestion d'équipe", "/gestionequipe", 4)}
              </tbody>
            </table>
          </div>
        </div>
      </div>;
    }
    return res;
  }

  trtSousMenu = (affichage, lien, droit) => {
    let res;
    if ((this.props.role & droit)===droit) {
      res=<tr>
            <td className="btn btn-block tdbar">
              <a className="btn-block lienbar" href={lien}>
                {affichage}
              </a>
            </td>
          </tr>;
    }
    return res;
  }

  render() {
    return (
      <div>
        <div className="panel panel-default">
          <div className="panel-heading">
            <a className="btn-block" href="/accueil">
              <h4 className="panel-title">
                <span className="glyphicon glyphicon-home"></span> Accueil
              </h4>
            </a>
          </div>
        </div>

        <div className="panel panel-default">
          <div className="panel-heading">
            <a data-toggle="collapse" data-parent="#accordion" href={"#collapse1"+this.props.cas}>
              <h4 className="panel-title">
                <span className="glyphicon glyphicon-user"></span> Absence
              </h4>
            </a>
          </div>
          <div id={"collapse1"+this.props.cas} className="panel-collapse collapse">
            <div className="panel-body">
              <table className="table">
                <tbody>
                  {this.trtSousMenu("Nouvelle demande", "/nouvelledemande", 0)}
                  {this.trtSousMenu("Déclaration d'absence", "/declareabsence", 1)}
                  {this.trtSousMenu("Reliquat de congés", "/reliquatconges", 1)}
                </tbody>
              </table>
            </div>
          </div>
        </div>

        <div className="panel panel-default">
          <div className="panel-heading">
            <a data-toggle="collapse" data-parent="#accordion" href={"#collapse2"+this.props.cas}>
              <h4 className="panel-title">
                <span className="glyphicon glyphicon-calendar"></span> Calendrier
              </h4>
            </a>
          </div>
          <div id={"collapse2"+this.props.cas} className="panel-collapse collapse">
            <div className="panel-body">
              <table className="table">
                <tbody>
                  {this.trtSousMenu("Mon calendrier", "/moncalendrier", 0)}
                  {this.trtSousMenu("Calendrier d'équipe", "/calendrierequipe", 0)}
                  {this.trtSousMenu("Calendrier du personnel", "/calendrierentreprise", 2)}
                </tbody>
              </table>
            </div>
          </div>
        </div>

        {this.trtMenu()}
        <div className="panel panel-default">
          <div className="panel-heading">
            <a data-toggle="collapse" data-parent="#accordion" href={"#collapse4"+this.props.cas}>
              <h4 className="panel-title">
                <span className="glyphicon glyphicon-question-sign"></span> Aide
              </h4>
            </a>
          </div>
          <div id={"collapse4"+this.props.cas} className="panel-collapse collapse">
            <div className="panel-body">
              <table className="table">
                <tbody>
                  {this.trtSousMenu("Aide", "/aide", 0)}
                  {this.trtSousMenu("A propos", "/apropos", 0)}
                </tbody>
              </table>
            </div>
          </div>
        </div>

        <div className="panel panel-default">
          <div className="panel-heading">
            <a data-toggle="collapse" data-parent="#accordion" href={"#collapse5"+this.props.cas}>
              <h4 className="panel-title">
                <span className="glyphicon glyphicon-off"></span> Session
              </h4>
            </a>
          </div>
          <div id={"collapse5"+this.props.cas} className="panel-collapse collapse">
            <div className="panel-body">
              <table className="table">
                <tbody>
                  {this.trtSousMenu("Déconnexion", "/deconnexion", 0)}
                  {this.trtSousMenu("Modifier mot de passe", "/modifmotdepasse", 0)}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    )};
  }
export default Menu;
