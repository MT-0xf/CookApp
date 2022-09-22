import type { NextPage } from 'next'
import Header from '../components/header'
import styled from 'styled-components'
import RecipeRegisterForm from '../components/recipeRegisterForm'

const RECIPE_REGISTER: NextPage = () => {
    const BACKGROUND = styled.div`
        width: 100%;
        height: 100%;
        background-color: black;
        display:inline-block;
        position: relative;
    `

    const BACKGROUND_IMG = styled.img`
        width: 100%;
        height: 1200px;
        display: inline-block;
        opacity: 0.5;
        object-fit: cover;
    `

    const MAIN_AREA = styled.div`
        width: 800px;
        height: 1000px;
        padding: 145px;
        background-color: white;
        opacity: 0.7;
        position: absolute;
        top: 7%;
        left: 18%;
    `;

    return (
        <div>
            <Header />

            <div className="background" >
                <img className="background-img" src='/assets/img/recipeRegister.jpg'></img>
                <div className="main-area">
                </div>
            </div>

            <RecipeRegisterForm />
        </div>
    )
  }
  
  export default RECIPE_REGISTER
  