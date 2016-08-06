package de.androbin.mep;

import de.androbin.mep.term.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import org.magicwerk.brownies.collections.*;

public final class TermFactory
{
	private TermFactory()
	{
	}
	
	public static Term random( final int depth, final int max )
	{
		return random( depth, max, ThreadLocalRandom.current() );
	}
	
	public static Term random( final int depth, final int max, final Random random )
	{
		final List<Term> terms = new ArrayList<Term>();
		
		{
			final int n = random.nextInt( ( 1 << depth ) - 1 ) + 1;
			
			for ( int i = 0; i < n; i++ )
			{
				final int r = ( random.nextInt( max + 1 ) << 1 ) - max + 1;
				terms.add( new Wrapper( BigDecimal.valueOf( r > 0 ? r : r - 1 ) ) );
			}
		}
		
		while ( terms.size() >= 2 )
		{
			final int i = random.nextInt( terms.size() - 1 );
			
			terms.add( i, Token.random().instantiate(
					terms.remove( i ),
					terms.remove( i ) ) );
		}
		
		return terms.get( 0 );
	}
}
