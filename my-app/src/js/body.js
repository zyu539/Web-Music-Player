import React from 'react';
import ReactDOM from 'react-dom';
const musicAPI = require('music-api');

class Header extends React.Component {
    render() {
        return (
            <a className="title">Music Player</a>
        );
    }
}

class SearchBar extends React.Component {
    state = {
        query: '',
        results: [],
    }
    
    handleInputChange = () => {
        this.setState({
            query: this.search.value
        })
    }
    
    getInfo = (e) => {
        e.preventDefault();
        musicAPI.searchSong('xiami', { key: 'taylor' })
        .then(res => {
            if (res.success) {
              console('???');
            } else {
              console('!!!');
            }
        })
        .catch(err => console.log(err));
    }
    
    render() {
        return (
            <div className="search-bar">
                <form action="/action_page.php">
                    <input type="text" placeholder="Search Songs..." name="search" ref={input => this.search = input} onChange={this.handleInputChange}/>
                <button type="submit" onClick={this.getInfo}>Submit</button>
                </form>
                <p>{this.state.results}</p>
            </div>
        );
    }
}

export {Header, SearchBar};

