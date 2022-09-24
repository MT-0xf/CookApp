import { gql } from '@apollo/client';

export const REGISTER_RECIPE = gql`
    mutation registerRecipeData($inputCreateRecipe: InputCreateRecipe!){
        registerRecipeData(inputCreateRecipe: $inputCreateRecipe)
    }
`;