
Infinitum : Magnitude {
	// this class has a single instance named inf
	// its main purpose is to respond to 'do' with an infinite loop.
	// useful for writing coroutines with a repeat count argument.
	// It also responds to magnitude comparisons.
	// This is not meant as a representation of a mathematical infinity.
	
	do { arg function;
		var i=0;
		// the compiler inserts special byte codes for this method.
		loop({
			function.value(i, i);
			i = i + 1;
		});
	}

	== { arg aNumber; _EQ; ^aNumber.performBinaryOpOnInfinitum('==', this) }
	!= { arg aNumber; _NE; ^aNumber.performBinaryOpOnInfinitum('!=', this) }
	< { arg aNumber; _LT; ^aNumber.performBinaryOpOnInfinitum('<', this) }
	> { arg aNumber; _GT; ^aNumber.performBinaryOpOnInfinitum('>', this) }
	<= { arg aNumber; _LE; ^aNumber.performBinaryOpOnInfinitum('<=', this) }
	>= { arg aNumber; _GE; ^aNumber.performBinaryOpOnInfinitum('>=', this) }
	min { arg aNumber; ^aNumber } 
	max { arg aNumber; ^this }

	performBinaryOpOnInfinitum { arg aSelector, aInf; ^error("Math operation failed.\n") }

	hash { _ObjectHash; ^this.primitiveFailed }

	*new { ^this.shouldNotImplement(thisMethod) }
	printOn { arg stream;
		stream.putAll("inf");
	}
	storeOn { arg stream;
		stream.putAll("inf");
	}
	archiveAsCompileString { ^true }
}




