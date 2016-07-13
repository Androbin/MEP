package de.androbin.mep.term.binary;

import de.androbin.mep.*;
import de.androbin.mep.term.*;
import java.math.*;

public final class XOR extends BinaryOperation
{
	public XOR( final BigDecimal first, final BigDecimal second )
	{
		super( first, second );
	}
	
	public XOR( final Term first, final Term second )
	{
		super( first, second );
	}
	
	@ Override
	public Token getToken()
	{
		return Token.XOR;
	}
	
	@ Override
	public BigInteger evaluate( final BigInteger first, final BigInteger second )
	{
		return first.xor( second );
	}
}