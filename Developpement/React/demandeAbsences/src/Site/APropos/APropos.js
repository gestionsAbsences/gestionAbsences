import React, { Component } from 'react';

import './aPropos.css';
import logo from '../Medias/Logo.jpg';

class APropos extends Component {
  render() {
    return (
      <div>
        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de Formulaire */}
            <h3 className="panel-title">A propos de l'application</h3>{/*'*/}
          </div>   {/*3   fin */}
          <div className="panel-body">   {/*4   Contenu Formulaire */}
            <div className="VOffSetHautAPropos">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css VOffSetHautPages */}{/*5   fin */}
            <div className="row apropos">
              <div className="col-md-12">
                <p className="titreAPropo"> <br />
                <img className="logohead" src={logo} alt="" />
                Gestion des absences v1.0
                </p>
                <p> <br />
                <span className="aproposLignes aproposLigne3">C'est dans le but d'obtenir le titre professionnel de Développeur-se logiciel - Niveau III.</span><br /> {/*'*/}
                    <span className="aproposLignes aproposLigne1">C'est une application permettant de gérer des absences dans une entreprise.</span><br /> {/*'*/}
                    <span className="aproposLignes aproposLigne2">C'est développée dans le cadre de la formation à l'école Simplon.</span><br /> {/*'*/}
                    <span className="aproposLignes aproposLigne4">C'est conçu par Fred, Jean et Mokhtar, 3 gars supers.</span><br /> {/*'*/}
                    <span className="aproposLignes aproposLigne5">C'est codé en Java et ReactJS entre autres.</span><br /> {/*'*/}
                    <span className="aproposLignes aproposLigne6">C'est  une appli client-serveur.</span><br /> {/*'*/}
                    <span className="aproposLignes aproposLigne7">Et c'est bien !</span><br /> {/*'*/}
                </p>
              </div>   {/*6   fin */}
            </div>
          </div>   {/*4   fin */}
          <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        </div>   {/*2   fin */}
        <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
      </div>
    );
  }
}

export default APropos;
