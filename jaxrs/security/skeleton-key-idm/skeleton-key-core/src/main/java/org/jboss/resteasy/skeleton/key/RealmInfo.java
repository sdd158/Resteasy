package org.jboss.resteasy.skeleton.key;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.skeleton.key.ResourceMetadata;
import org.jboss.resteasy.skeleton.key.SkeletonKeyTokenVerification;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.UriBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class RealmInfo
{
   protected ResourceMetadata metadata;
   protected ResteasyClient client;
   protected UriBuilder authUrl;
   protected ResteasyWebTarget tokenUrl;
   protected String clientId;
   protected Form credentials = new Form();
   protected String cookiePath;
   protected boolean cookieSecure;
   protected boolean sslRequired = true;
   protected Map<String, SkeletonKeyTokenVerification> verifications = new HashMap<String, SkeletonKeyTokenVerification>();

   public ResourceMetadata getMetadata()
   {
      return metadata;
   }

   public void setMetadata(ResourceMetadata metadata)
   {
      this.metadata = metadata;
   }

   public ResteasyClient getClient()
   {
      return client;
   }

   public void setClient(ResteasyClient client)
   {
      this.client = client;
   }

   public UriBuilder getAuthUrl()
   {
      return authUrl;
   }

   public void setAuthUrl(UriBuilder authUrl)
   {
      this.authUrl = authUrl;
   }

   public String getClientId()
   {
      return clientId;
   }

   public void setClientId(String clientId)
   {
      this.clientId = clientId;
   }

   public Form getCredentials()
   {
      return credentials;
   }

   public ResteasyWebTarget getTokenUrl()
   {
      return tokenUrl;
   }

   public void setTokenUrl(ResteasyWebTarget tokenUrl)
   {
      this.tokenUrl = tokenUrl;
   }

   public String getCookiePath()
   {
      return cookiePath;
   }

   public void setCookiePath(String cookiePath)
   {
      this.cookiePath = cookiePath;
   }

   public boolean isCookieSecure()
   {
      return cookieSecure;
   }

   public void setCookieSecure(boolean cookieSecure)
   {
      this.cookieSecure = cookieSecure;
   }

   public SkeletonKeyTokenVerification getVerification(String id)
   {
      synchronized(verifications)
      {
         return verifications.get(id);
      }
   }

   public void register(String id, SkeletonKeyTokenVerification verification)
   {
      synchronized (verifications)
      {
         verifications.put(id, verification);
      }
   }

   public boolean isSslRequired()
   {
      return sslRequired;
   }

   public void setSslRequired(boolean sslRequired)
   {
      this.sslRequired = sslRequired;
   }
}
