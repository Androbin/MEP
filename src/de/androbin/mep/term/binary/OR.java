package de.androbin.mep.term.binary;

import de.androbin.mep.*;
import de.androbin.mep.term.*;
import java.math.*;

public final class OR extends BinaryOperation
{
	public OR( final BigDecimal first, final BigDecimal second )
	{
		super( first, second );
	}
	
	public OR( final Term first, final Term second )
	{
		super( first, second );
	}
	
	@ Override
	public Token getToken()
	{
		return Token.OR;
	}
	
	@ Override
	public BigInteger evaluate( final BigInteger first, final BigInteger second )
	{
		return first.or( second );
	}
}