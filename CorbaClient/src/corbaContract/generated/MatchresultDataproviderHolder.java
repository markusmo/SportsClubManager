package corbaContract.generated;

/**
* corbaContract/generated/MatchresultDataproviderHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from matchresult.idl
* Freitag, 16. November 2012 15:31 Uhr MEZ
*/

public final class MatchresultDataproviderHolder implements org.omg.CORBA.portable.Streamable
{
  public corbaContract.generated.MatchresultDataprovider value = null;

  public MatchresultDataproviderHolder ()
  {
  }

  public MatchresultDataproviderHolder (corbaContract.generated.MatchresultDataprovider initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corbaContract.generated.MatchresultDataproviderHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corbaContract.generated.MatchresultDataproviderHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corbaContract.generated.MatchresultDataproviderHelper.type ();
  }

}
