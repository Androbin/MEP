package de.androbin.mep.term.binary;

import de.androbin.mep.*;
import de.androbin.mep.term.*;
import java.math.*;

public final class AND extends BinaryOperation
{
	public AND( final BigDecimal first, final BigDecimal second )
	{
		super( first, second );
	}
	
	public AND( final Term first, final Term second )
	{
		super( first, second );
	}
	
	@ Override
	public Token getToken()
	{
		return Token.AND;
	}
	
	@ Override
	public BigInteger evaluate( final BigInteger first, final BigInteger second )
	{
		return first.and( second );
	}
}