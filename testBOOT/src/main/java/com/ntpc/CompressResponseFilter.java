package com.ntpc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;



import com.googlecode.htmlcompressor.compressor.HtmlCompressor;


public class CompressResponseFilter implements Filter {

	private HtmlCompressor compressor;


	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {

        HtmlResponseWrapper capturingResponseWrapper = new HtmlResponseWrapper(
                (HttpServletResponse) response);

        filterChain.doFilter(request, capturingResponseWrapper);

       
       // if (response.getContentType() != null
              //  && response.getContentType().contains("text/html")) {

            String content = capturingResponseWrapper.getCaptureAsString();

            String replacedContent=compressor.compress(content);
           // replacedContent="I LOVE U";
            //System.out.println(replacedContent);
            
            response.setContentLength( replacedContent.length() );
            response.getWriter().write(replacedContent);
           
           

      //  }
        
       

    }
	

	@Override
	public void init(FilterConfig config) throws ServletException {
		compressor = new HtmlCompressor();
		compressor.setCompressCss(true);
		compressor.setCompressJavaScript(true);
		
	}

	@Override
	public void destroy() {
	}

}
