package de.androbin.mep;

import de.androbin.mep.term.*;
import java.math.*;
import java.util.*;

public final class MEP {
  private MEP() {
  }
  
  private static void addToken( final MathContext context, final List<Token> tokens,
      final List<Term> terms, final StringBuilder builder ) {
    if ( !builder.toString().trim().isEmpty() ) {
      final String s = builder.toString().trim();
      
      if ( !s.isEmpty() ) {
        final Term term = Term.wrap( context, s );
        tokens.add( Token.TERM );
        terms.add( term );
      }
    }
  }
  
  public static Term parseTerm( final MathContext context, final String expression ) {
    final List<Token> tokens = new ArrayList<>();
    final List<Term> terms = new ArrayList<>();
    
    if ( testForBrackets( expression ) ) {
      String e = expression;
      
      do {
        final int o = openIndex( e );
        final int c = closeIndex( e, o );
        
        parseTokens( context, e.substring( 0, o ), tokens, terms );
        terms.add( parseTerm( context, e.substring( o + 1, c ) ) );
        
        if ( e.length() == expression.length() && !tokens.isEmpty()
            && tokens.get( 0 ) == Token.MINUS ) {
          tokens.remove( 0 );
          terms.set( 0, Term.negate( context, terms.get( 0 ) ) );
        }
        
        tokens.add( Token.TERM );
        e = e.substring( c + 1 );
      } while ( testForBrackets( e ) );
      
      if ( !e.trim().isEmpty() ) {
        parseTokens( context, e, tokens, terms );
      }
    } else {
      parseTokens( context, expression, tokens, terms );
    }
    
    return parseTerm( tokens, terms );
  }
  
  private static int closeIndex( final String expression, final int o ) throws InternalError {
    int l = 0;
    
    for ( int i = o; i < expression.length(); i++ ) {
      final char c = expression.charAt( i );
      
      if ( c == '(' ) {
        l++;
      } else if ( c == ')' ) {
        l--;
        
        if ( l == 0 ) {
          return i;
        }
      }
    }
    
    throw new InternalError();
    
  }
  
  private static int openIndex( final String expression ) {
    return expression.indexOf( '(' );
  }
  
  private static Term parseTerm( final List<Token> tokens, final List<Term> terms ) {
    for ( int p = 15; p > 0; p-- ) {
      int n = -1;
      
      for ( int i = 0; i < tokens.size(); i++ ) {
        final Token token = tokens.get( i );
        
        if ( token == Token.TERM ) {
          n++;
        } else if ( token.pre == p ) {
          tokens.remove( i + 1 );
          tokens.remove( i );
          tokens.set( --i, Token.TERM );
          
          terms.add( n, token.instantiate( terms.get( n ), terms.get( ++n ) ) );
          terms.remove( n );
          terms.remove( n-- );
        }
      }
    }
    
    return terms.get( 0 );
  }
  
  private static void parseTokens( final MathContext context, final String expression,
      final List<Token> tokens, final List<Term> terms ) {
    final StringBuilder builder = new StringBuilder();
    boolean beginning = true;
    
    for ( int i = 0; i < expression.length(); i++ ) {
      final char c = expression.charAt( i );
      
      if ( c == ' ' ) {
        continue;
      }
      
      final Token token = Token.get( c );
      
      if ( token == null || beginning && c == '-' ) {
        builder.append( c );
        beginning = false;
      } else {
        addToken( context, tokens, terms, builder );
        tokens.add( token );
        builder.setLength( 0 );
      }
    }
    
    if ( builder.toString().equals( "-" ) ) {
      tokens.add( Token.MINUS );
    } else {
      addToken( context, tokens, terms, builder );
    }
  }
  
  private static boolean testForBrackets( final String expression ) {
    return expression.matches( ".*\\(.*\\).*" );
  }
}