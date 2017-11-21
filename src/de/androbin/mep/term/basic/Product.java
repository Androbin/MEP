package de.androbin.mep.term.basic;

import de.androbin.mep.*;
import de.androbin.mep.term.*;
import java.math.*;

public final class Product extends BiOperation {
  public Product( final BigDecimal first, final BigDecimal second ) {
    super( first, second );
  }
  
  public Product( final Term first, final Term second ) {
    super( first, second );
  }
  
  @ Override
  public Token getToken() {
    return Token.TIMES;
  }
  
  @ Override
  public BigDecimal evaluate( final MathContext context,
      final BigDecimal first, final BigDecimal second ) {
    return first.multiply( second, context );
  }
}