package de.androbin.mep;

import static de.androbin.collection.util.ObjectCollectionUtil.*;
import de.androbin.mep.term.*;
import de.androbin.mep.term.basic.*;
import de.androbin.mep.term.binary.*;
import java.util.function.*;

public enum Token {
  TERM( ' ', 15, ( t, u ) -> null ),
  TIMES( '*', 12, ( t, u ) -> new Product( t, u ) ),
  OVER( '/', 12, ( t, u ) -> new Quotient( t, u ) ),
  MODULO( '%', 12, ( t, u ) -> new Modulo( t, u ) ),
  PLUS( '+', 11, ( t, u ) -> new Sum( t, u ) ),
  MINUS( '-', 11, ( t, u ) -> new Difference( t, u ) ),
  AND( '&', 7, ( t, u ) -> new AND( t, u ) ),
  XOR( '^', 6, ( t, u ) -> new XOR( t, u ) ),
  OR( '|', 5, ( t, u ) -> new OR( t, u ) );
  
  public final char op;
  public final int pre;
  
  private final BinaryOperator<Term> instantiator;
  
  private Token( final char c, final int p, final BinaryOperator<Term> instantiator ) {
    this.op = c;
    this.pre = p;
    
    this.instantiator = instantiator;
  }
  
  public static Token get( final char op ) {
    for ( final Token token : values() ) {
      if ( token.op == op ) {
        return token;
      }
    }
    
    return null;
  }
  
  public Term instantiate( final Term first, final Term second ) {
    return instantiator.apply( first, second );
  }
  
  public static Token random() {
    return randomElement( values(), null );
  }
}