import '../styles/globals.css'
import type { AppProps } from 'next/app'
import '../styles/search-results.css'
import '../styles/recipe-register.css'
import '../styles/top.css'
import '../styles/header.css'
import '../styles/overlaySpinner.css'

import {
  ApolloClient,
  InMemoryCache,
  ApolloProvider,
  createHttpLink,
} from "@apollo/client";

const cache = new InMemoryCache();
const client = new ApolloClient({
  uri: `http://localhost:8080/graphql`,
  cache,
});


function MyApp({ Component, pageProps }: AppProps) {
  return (
    <ApolloProvider client={client}>
      <Component {...pageProps} />
    </ApolloProvider>
  )
}

export default MyApp
