package de.androbin.mep.term.basic;

import de.androbin.mep.*;
import de.androbin.mep.term.*;
import java.math.*;

public final class Difference extends BiOperation {
  public Difference( final BigDecimal minuend, final BigDecimal subtrahend ) {
    super( minuend, subtrahend );
  }
  
  public Difference( final Term minuend, final Term subtrahend ) {
    super( minuend, subtrahend );
  }
  
  @ Override
  public Token getToken() {
    return Token.MINUS;
  }
  
  @ Override
  public BigDecimal evaluate( final MathContext context,
      final BigDecimal first, final BigDecimal second ) {
    return first.subtract( second, context );
  }
}