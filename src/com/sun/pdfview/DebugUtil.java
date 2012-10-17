package com.sun.pdfview;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * debugging functions
 * author: yarick123@gmail.com
 */
public class DebugUtil {
    private static int test_jpg_count;

    /**
     * writes ByteBuffer to the current directory.
     * Name schema: jpg_<++test_jpg_count>.jpeg
     * @param jpegData
     */
    public static void write_jpeg( ByteBuffer jpegData ) {
        if( null != jpegData ) {
            jpegData.mark();
            FileOutputStream os = null;
            try {
                os = new FileOutputStream( "jpg_"+(++test_jpg_count)+".jpeg" );
                InputStream is = new ByteBufferInputStream(jpegData);
                byte [] bytes = new byte[1024];
                for( int read=0; read >= 0; read = is.read( bytes ) )
                    os.write( bytes, 0, read );
            }
            catch ( Exception e ) { e.printStackTrace(); }
            finally {
                jpegData.reset();
                if( null != os ) try { os.close(); } catch( IOException e ) { e.printStackTrace(); }
            }
        }
    }
}