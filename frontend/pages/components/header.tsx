import type { NextPage } from 'next'
import Head from 'next/head'

import styled from 'styled-components'
import { useEffect, useState } from 'react'

export const Header: NextPage = () => {
  const [width, setWidth] = useState(0);  
  useEffect(() => {
      setWidth(window.innerWidth);  
  },[]);
  
  const HEADER = styled.div`
    background-color: #ff4500;
    color: white;
    padding: 13px 100px 10px 100px;
    height: 45px;
    @media (max-width: 747px) { 
      padding: 13px 100px 10px 30px;
    }
  `

  const HEADER_LEFT = styled.span`
    float: left;
  `
  const HEADER_RIGHT = styled.span`
    float: right;
    &:hover { text-decoration: underline; }
  `

  const HEADER_RIGHT_ITEM = styled.span`
    margin-right: 40px;
  `

  return (
    <div>
      <div className="header">
        { width < 1020 ? 
            <div className="header-left">
              CookApp
            </div>
            :
            <div className="header-left">
              料理を通じて暮らしを豊かに
            </div>
        }
        
        <div className="header-right">
          <div className="header-right-item">
            レシピをつくる
          </div>
        </div>
      </div>
    </div>
  )
}

export default Header
