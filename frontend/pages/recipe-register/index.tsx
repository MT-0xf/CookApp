import type { NextPage } from 'next'
import Header from '../components/header'
import styled from 'styled-components'

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

    const INPUT_FORM = styled.div`
        position: absolute;
        top: 35%;
        left: 30%;
        height: 800px;
    `

    const INPUT_TEXT = styled.input`
        margin-top: 15px;
        font-size: 22px;
        padding: 10px 5px 10px 5px;
        width: 480px;
        background: white;
        @media (max-width: 747px) {
            width: 250px;
        }
    `

    const INPUT_TEXT_INGREDIENT = styled.input`
        margin-top: 15px;
        font-size: 22px;
        padding: 10px 5px 10px 5px;
        width: 370px;
        margin-right: 10px;
        background: white;
        @media (max-width: 747px) {
            width: 250px;
        }
    `

    const INPUT_TEXT_AMOUNT = styled.input`
        margin-top: 15px;
        font-size: 22px;
        padding: 10px 5px 10px 5px;
        width: 100px;
        background: white;
        @media (max-width: 747px) {
            width: 250px;
        }
    `

    const INPUT_TEXTAREA = styled.textarea`
        margin-top: 15px;
        font-size: 22px;
        padding: 10px 5px 10px 5px;
        width: 480px;
        resize: none;
        background: white;
        @media (max-width: 747px) {
            width: 250px;
        }
    `

    const INPUT_FILE = styled.input`
    `

    const INPUT_LABEL = styled.div`
        margin-top: 15px;
    `

    return (
        <div>
            <Header />

            <BACKGROUND>
                <BACKGROUND_IMG src='/assets/img/recipeRegister.jpg'></BACKGROUND_IMG>
                <MAIN_AREA>
                </MAIN_AREA>
            </BACKGROUND>
            
            <INPUT_FORM>
                <h1>レシピ入力</h1>
                <INPUT_TEXT placeholder='料理名'></INPUT_TEXT><br/>

                <INPUT_LABEL>料理画像</INPUT_LABEL>
                <INPUT_FILE type="file"></INPUT_FILE><br/>

                <INPUT_LABEL>材料1</INPUT_LABEL>
                <INPUT_TEXT_INGREDIENT placeholder='材料'></INPUT_TEXT_INGREDIENT>
                <INPUT_TEXT_AMOUNT placeholder='分量'></INPUT_TEXT_AMOUNT>

                <INPUT_LABEL>材料2</INPUT_LABEL>
                <INPUT_TEXT_INGREDIENT placeholder='材料'></INPUT_TEXT_INGREDIENT>
                <INPUT_TEXT_AMOUNT placeholder='分量'></INPUT_TEXT_AMOUNT>

                <INPUT_LABEL>材料3</INPUT_LABEL>
                <INPUT_TEXT_INGREDIENT placeholder='材料'></INPUT_TEXT_INGREDIENT>
                <INPUT_TEXT_AMOUNT placeholder='分量'></INPUT_TEXT_AMOUNT>

                <INPUT_LABEL>手順1</INPUT_LABEL>
                <INPUT_LABEL>調理画像</INPUT_LABEL>
                <INPUT_FILE type="file"></INPUT_FILE><br/>
                <INPUT_TEXTAREA placeholder='手順'></INPUT_TEXTAREA>

                <INPUT_LABEL>手順2</INPUT_LABEL>
                <INPUT_LABEL>調理画像</INPUT_LABEL>
                <INPUT_FILE type="file"></INPUT_FILE><br/>
                <INPUT_TEXTAREA placeholder='手順'></INPUT_TEXTAREA>

            </INPUT_FORM>
        </div>
    )
  }
  
  export default RECIPE_REGISTER
  