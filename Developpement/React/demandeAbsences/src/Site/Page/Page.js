import React, { Component } from 'react';
//import { CloudinaryContext, Transformation, Image } from 'cloudinary-react';

import './page.css';
import '../Bootstrap/dist/css/sb-admin-2.css'
import axios from 'axios'

import Authentification from './Authentification/Authentification.js';

class Page extends Component {

  constructor(props) {
      super(props);
      this.state = {
          donnees: []
      }
  }
  componentDidMount() {
       axios.get('http://localhost:8080/type/listeService/')
          .then(res => {
              console.log(res.data.resources);
              this.setState({type: res.data.resources});
      });
  }
  render() {
    return (
      <div>
        <Authentification />
        <div className="marge"></div>
      </div>
    );
  }
}

export default Page;
