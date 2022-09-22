import type { NextPage } from 'next'
import Head from 'next/head'

import styled from 'styled-components'
import { useEffect, useState } from 'react'

export const Header: NextPage = () => {
  const [width, setWidth] = useState(0);  
  useEffect(() => {
      setWidth(window.innerWidth);  
  },[]);

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
