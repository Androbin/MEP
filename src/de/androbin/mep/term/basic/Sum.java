package de.androbin.mep.term.basic;

import de.androbin.mep.*;
import de.androbin.mep.term.*;
import java.math.*;

public final class Sum extends BiOperation {
  public Sum( final BigDecimal first, final BigDecimal second ) {
    super( first, second );
  }
  
  public Sum( final Term first, final Term second ) {
    super( first, second );
  }
  
  @ Override
  public Token getToken() {
    return Token.PLUS;
  }
  
  @ Override
  public BigDecimal evaluate( final MathContext context,
      final BigDecimal first, final BigDecimal second ) {
    return first.add( second, context );
  }
}