import { gql } from '@apollo/client';
import { User } from '../../types';

export const POSTS_QUERY = gql`
  query {
    getUsers {
      id
      name
      password
    }
  }
`;

export interface UserData {
  users: User[];
}
