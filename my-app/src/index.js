import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import {Header, SearchBar} from './js/body.js';
import './index.css';

ReactDOM.render(
    [<Header />, <SearchBar />],
    document.getElementById('app'),
);

