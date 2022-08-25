import React from 'react';
import { Link } from "react-router-dom";

import {
    CollectionIcon,
    HomeIcon,
    LightningBoltIcon,
    SearchIcon,
    UserIcon
} from "@heroicons/react/outline";
import NavItems from "./NavItems";

const Header = () => {
    return (
            <nav className="nav">
                <div className="icons">
                    <Link to="/" style={{ textDecoration: 'none' }}> <NavItems title="HOME" Icon={HomeIcon} /></Link>
                    <NavItems title="SEARCH" Icon={SearchIcon} />
                    <NavItems title="TRENDING" Icon={LightningBoltIcon} />
                    <NavItems title="COLLECTIONS" Icon={CollectionIcon} />
                    <Link to="Login" style={{ textDecoration: 'none' }}><NavItems title="LOGIN" Icon={UserIcon} /></Link>
                </div>
            </nav>
    );
}

export default Header;