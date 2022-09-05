import { gql } from '@apollo/client';

export const POSTS_QUERY = gql`
  query {
    getUsers {
      id
      name
      password
    }
  }
`;

export const GET_RECIPE_DATA_QUERY = gql`
  query {
    getRecipeData {
      dish_name
      ingredients {
        ingredient_name
        amount
      }
      procedures {
        order
        method
        img
      }
    }
  }
`;