package com.sun.pdfview;

/**
 * contains Properties, used by PDFRenderer
 * author: yarick123@gmail.com
 */
public class PDFRendererConfig {
    protected static PDFRendererConfig myInstance;

    protected final static boolean Prop_SkipErrors = "true".equalsIgnoreCase( System.getProperty( "PDFRenderer.SkipErrors", "true" ) );

    public static synchronized PDFRendererConfig getInstance() {
        if( null == myInstance )
            myInstance = new PDFRendererConfig();
        return myInstance;
    }

    public static synchronized void setInstance( PDFRendererConfig config ) {
        if( null == myInstance )
            myInstance = new PDFRendererConfig();
        else
            System.err.print( "PDFRendererConfig: cannot override existing configuration" );
    }

    public boolean isSkipErrors() {
        return Prop_SkipErrors;
    }
}