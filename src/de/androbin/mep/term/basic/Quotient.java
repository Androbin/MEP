package de.androbin.mep.term.basic;

import de.androbin.mep.*;
import de.androbin.mep.term.*;
import java.math.*;

public final class Quotient extends BiOperation {
  public Quotient( final BigDecimal dividend, final BigDecimal divisor ) {
    super( dividend, divisor );
  }
  
  public Quotient( final Term dividend, final Term divisor ) {
    super( dividend, divisor );
  }
  
  @ Override
  public Token getToken() {
    return Token.OVER;
  }
  
  @ Override
  public BigDecimal evaluate( final MathContext context,
      final BigDecimal first, final BigDecimal second ) {
    return first.divide( second, context );
  }
}