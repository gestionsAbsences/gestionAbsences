import React, { Component } from 'react';
import axios from 'axios';

import $ from 'jquery';
import 'datatables.net';

import 'bootstrap/dist/css/bootstrap.css';
import 'datatables.net-bs/js/dataTables.bootstrap';
import 'datatables.net-bs/css/dataTables.bootstrap.css';

import 'datatables.net-fixedheader';
import 'datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.css';

import './reliquatconges.css';

class ReliquatConges extends Component {

  constructor(props) {
      super(props);
      this.state = {
          employes: [],
          liste: []
      }
  }

  componentDidMount() {
    //Requête HTTP destinée au Back
    axios({
      method: 'get',
      url: '/emp/listeEmployes',
      data: {},
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
      }
    })
      .then(res => {

        // Incorpore les données dans le State
        this.setState({
          employes: res.data
        });
        if (this.props.employe.modeDev) {
          console.log("Requête satisfaite : ");
          console.log(res);
          console.log("");
        }
      })
      // Traitement des erreurs en mode de Dev.
      .catch((error) => {
        if (this.props.employe.modeDev) {
          if (axios.isCancel(error)) {
            console.log("La requête a été annulée :");
            console.log('Request canceled', error.message);
            console.log("");
          } else if (error.response) {
            console.log("La requête est transmise mais retourne une erreur <200 ou >=300 :");
            console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);
            console.log("");
          } else if (error.request) {
            console.log("La requête est transmise mais ne retourne pas de réponse : ");
            console.log(error.request);
            console.log("");
          } else {
            console.log("La requête n'a pu être transmise et déclenche une erreur : ");
            console.log('Error', error.message);
            console.log("");
          }
          console.log("Error.config : ");
          console.log(error.config);
          console.log("");
        }
      });


  }

  // componentDidUpdate() {
  //   this.state.employes.map(
  //     (employe, i) => {
  //     this.state.liste.data[i].push(employe.nom);
  //     this.state.liste.data[i].push(employe.prenom);
  //     this.state.liste.data[i].push(employe.matricule);
  //     this.state.liste.data[i].push(employe.nomResponsable);
  //     this.state.liste.data[i].push(employe.prenomResponsable);
  //     this.state.liste.data[i].push(employe.nbCa);
  //     this.state.liste.data[i].push(employe.nbRtt);
  //     this.state.liste.data[i].push(employe.nbRc);
  //   })
  //   console.log(this.state.liste);
  // }

  render() {
    return (
      <div>


        <div className="panel panel-default">   {/*2   Formulaire */}
          <div className="panel-heading">   {/*3   Titre de la page */}
            <h3 className="panel-title">Reliquat des congés de votre équipe</h3>
          </div>   {/*3   fin */}

          <div className="panel-body">
          	<div className="dataTables_wrapper form-inline dt-bootstrap no-footer" id="dataTables-example_wrapper">
{/*
          		<div className="row">
          			<div className="col-sm-6">
          				<div id="dataTables-example_length" className="dataTables_length">
          					<label className="ajust">Show&nbsp;&nbsp;
          						<select className="form-control input-sm" aria-controls="dataTables-example" name="dataTables-example_length">
          							<option value="10">10</option>
          							<option value="25">25</option>
          							<option value="50">50</option>
          							<option value="100">100</option>
          						</select>&nbsp;&nbsp;entries
          					</label>
          				</div>
          			</div>
          			<div className="col-sm-6">
          				<div className="dataTables_filter pull-right" id="dataTables-example_filter">
          					<label className="ajust">Search :&nbsp;
          						<input aria-controls="dataTables-example" placeholder="" className="form-control input-sm" type="search" />
          					</label>
          				</div>
          			</div>
          		</div>
*/}
          		<div className="row">
          			<div className="col-sm-12">
                  <table ref={elm=>$(elm).DataTable()} aria-describedby="dataTables-example_info" role="grid" className="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="table">

{/* <table ref={this.state.employes=>$(table).DataTable()} aria-describedby="dataTables-example_info" role="grid" className="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="table"> */}

          					<thead>
          						<tr role="row">
                        <th
                            className="sorting_asc"
                            tabIndex="0"
                            aria-controls="dataTables-example"
                            aria-label="Rendering engine: activate to sort column descending"
                            aria-sort="ascending"
                        >Nom</th>
          							<th
                            className="sorting"
                            tabIndex="0"
                            aria-controls="dataTables-example"
                            aria-label="Browser: activate to sort column ascending"
                        >Prénom</th>
          							<th
                            className="sorting"
                            tabIndex="0"
                            aria-label="Platform(s): activate to sort column ascending"
                            aria-controls="dataTables-example"
                        >Matricule</th>
          							<th
                            className="sorting"
                            tabIndex="0"
                            aria-label="Engine version: activate to sort column ascending"
                            aria-controls="dataTables-example"
                        >Nom Resp</th>
                        <th
                            className="sorting"
                            tabIndex="0"
                            aria-label="CSS grade: activate to sort column ascending"
                            aria-controls="dataTables-example"
                        >Prénom Resp</th>
                        <th
                            className="sorting"
                            tabIndex="0"
                            aria-label="CSS grade: activate to sort column ascending"
                            aria-controls="dataTables-example"
                        >CA</th>
                        <th
                            className="sorting"
                            tabIndex="0"
                            aria-label="CSS grade: activate to sort column ascending"
                            aria-controls="dataTables-example"
                        >RTT</th>
                        <th
                            className="sorting"
                            tabIndex="0"
                            aria-label="CSS grade: activate to sort column ascending"
                            aria-controls="dataTables-example"
                        >RC</th>
          						</tr>
          					</thead>
          					<tbody>
                      {/*
                        this.state.employes.map(
                          (employe, i) =>
                          <tr>
                            <td>{employe.nom}</td>
                            <td>{employe.prenom}</td>
                            <td>{employe.matricule}</td>
                            <td>{employe.nomResponsable}</td>
                            <td>{employe.prenomResponsable}</td>
                            <td className="text-center">{employe.nbCa}</td>
                            <td className="text-center">{employe.nbRtt}</td>
                            <td className="text-center">{employe.nbRc}</td>
                          </tr>
                        )
                      */}
                    </tbody>{/*16 Fin */}
                  </table>
                  </div>
            		</div>
{/*
            		<div className="row">
            			<div className="col-sm-6">
            				<div aria-live="polite" role="status" id="dataTables-example_info" className="dataTables_info">Showing 1 to 10 of 57 entries</div>
            			</div>
            			<div className="col-sm-6">
            				<div id="dataTables-example_paginate" className="dataTables_paginate paging_simple_numbers">
            					<ul className="pagination">
            						<li id="dataTables-example_previous" tabIndex="0" aria-controls="dataTables-example" className="paginate_button previous disabled">
            							<a href="#">Previous</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button active">
            							<a href="#">1</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">2</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">3</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">4</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">5</a>
            						</li>
            						<li tabIndex="0" aria-controls="dataTables-example" className="paginate_button ">
            							<a href="#">6</a>
            						</li>
            						<li id="dataTables-example_next" tabIndex="0" aria-controls="dataTables-example" className="paginate_button next">
            							<a href="#">Next</a>
            						</li>
            					</ul>
            				</div>
            			</div>
                </div>
*/}
              </div>
            </div>
          </div>   {/*2 Fin */}
          <div className="VOffSetBasPages">&nbsp;</div>   {/*1   Cosmétique Ajout d'une marge en dessous du formulaire réglable via le css voffsetpos */}{/*1    fin */}
        </div>
    );
  }
}

export default ReliquatConges;
