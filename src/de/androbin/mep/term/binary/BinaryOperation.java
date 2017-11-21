package de.androbin.mep.term.binary;

import de.androbin.mep.term.*;
import java.math.*;

public abstract class BinaryOperation extends BiOperation {
  public BinaryOperation( final BigDecimal first, final BigDecimal second ) {
    super( first, second );
  }
  
  public BinaryOperation( final Term first, final Term second ) {
    super( first, second );
  }
  
  @ Override
  public BigDecimal evaluate( final MathContext context,
      final BigDecimal first, final BigDecimal second ) {
    return new BigDecimal( evaluate( first.toBigInteger(), second.toBigInteger() ) );
  }
  
  public abstract BigInteger evaluate( BigInteger first, BigInteger second );
}