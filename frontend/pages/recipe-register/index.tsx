import type { NextPage } from 'next'
import Header from '../components/header'
import RecipeRegisterForm from '../components/recipeRegisterForm'

const RECIPE_REGISTER: NextPage = () => {
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
  