package de.androbin.mep.term;

import de.androbin.mep.*;
import java.math.*;

public interface Term {
  BigDecimal evaluate( final MathContext context );
  
  default Token getToken() {
    return Token.TERM;
  }
  
  static Term negate( final MathContext context, final Term term ) {
    return term instanceof Wrapper ? new Wrapper( ( (Wrapper) term ).getNumber().negate( context ) )
        : new Negation( term );
  }
  
  static BigDecimal parseNumber( final MathContext context, final String expression ) {
    try {
      return new BigDecimal( expression.trim(), context );
    } catch ( final NumberFormatException ignore ) {
      return null;
    }
  }
  
  String toString( final MathContext context );
  
  static Term wrap( final MathContext context, final String expression ) {
    final BigDecimal number = parseNumber( context, expression );
    return number == null ? new Variable( expression ) : new Wrapper( number );
  }
}