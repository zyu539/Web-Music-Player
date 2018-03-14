import React from 'react';
import ReactDOM from 'react-dom';
import '../css/navbar.css';

class NavBarComponent extends React.Component {
    render() {
        return (
            <nav className="navbar navbar-default">
            <div className="container">
                <div className="navbar-header">
                    <button type="button" className="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#navbar-collapse-2">
                        <span className="sr-only">Toggle navigation</span> <span
                            className="icon-bar"></span> <span className="icon-bar"></span> <span
                                className="icon-bar"></span>
                    </button>
                    <a className="navbar-brand" href="#"><img
                        src={require('src/images/brand.svg')} width="30" height="30"/></a>
                </div>
                
                <div className="collapse navbar-collapse" id="navbar-collapse-2">
                    <ul className="nav navbar-nav navbar-right">
                        <li><a href="/register">Register</a></li>
                        <li><a
                            className="btn btn-default btn-outline btn-circle collapsed"
                            data-toggle="collapse" href="#nav-collapse2" aria-expanded="false"
                            aria-controls="nav-collapse2">Sign in</a></li>
                    </ul>
                    <div className="collapse nav navbar-nav nav-collapse slide-down"
                        id="nav-collapse2">
                        <form className="navbar-form navbar-right form-inline" role="form">
                            <div className="form-group">
                                <label className="sr-only" htmlFor="Email">Email</label> <input
                                type="email" className="form-control" id="Email" placeholder="Email"
                                autofocus required />
                            </div>
                            <div className="form-group">
                                <label className="sr-only" htmlFor="Password">Password</label> <input
                                type="password" className="form-control" id="Password"
                                placeholder="Password" required />
                            </div>
                            <button type="submit" className="btn btn-success">Sign in</button>
                        </form>
                    </div>
                </div>
            </div>
            </nav>
        );
    }
}

export default NavBarComponent;

