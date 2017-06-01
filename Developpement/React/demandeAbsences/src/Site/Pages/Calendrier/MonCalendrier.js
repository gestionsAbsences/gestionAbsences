import React, { Component } from 'react';

import './calendrier.css';

class MonCalendrier extends Component {
  render() {
    return (
      <div>
        <div className="voffsetpos">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge au dessus du formulaire réglable via le css voffsetpos */}{/*1    fin */}
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <h3 className="panel-title">Mon calendrier</h3>
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="voffsethaut">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css voffsethaut */}{/*5   fin */}
            <div id="moncalendrier" className="container-fluid">
              <div className="col-md-10" id="calendarList">
                <table id="calendrier" className="calendrier display border">
                   <tbody id="calendrierbody">
                   </tbody>
                </table>
              </div>
              <div id="legendText" className="calendrier col-md-2">
                <table id="legend" className="legend display border">
                   <tbody id="legendbody">
                   </tbody>
                </table>
              </div>
            </div>

            <div className="col-md-4 col-md-offset-4">

              <div className="row">   {/*11   Block Boutons Soumettre et Annuler */}
                <div className="voffsetbas">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
                <div className="text-center">
                  <a id="leftcalendrier" href="#" className="btn btn-primary">
                    <span className="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>
                  </a>
                  <a id="todaycalendrier" href="#" className="btn btn-primary">
                    <span className="">Aujourd'hui</span>{/*'*/}
                  </a>
                  <a id="rightcalendrier" href="#" className="btn btn-primary">
                    <span className="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>
                  </a>
                </div>
                <div className="voffsetbas">&nbsp;</div>   {/*12   Cosmétique d'unee marge au dessus des boutons */}{/*12   fin */}
              </div>   {/*11   fin */}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default MonCalendrier;
