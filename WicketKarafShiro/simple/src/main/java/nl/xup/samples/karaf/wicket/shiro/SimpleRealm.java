package nl.xup.samples.karaf.wicket.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Simple shiro realm with only a few hard coded users
 * 
 * @author Minto van der Sluis (misl)
 */
public class SimpleRealm extends AuthorizingRealm {

  // --------------------------------------------------------------------------
  // Constructors 
  // --------------------------------------------------------------------------
  
  public SimpleRealm() {
    setName( "memoryRealm" );
    CredentialsMatcher cm = new SimpleCredentialsMatcher();
    setCredentialsMatcher( cm );
  }

  // --------------------------------------------------------------------------
  // Overrides 
  // --------------------------------------------------------------------------

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo( PrincipalCollection principalCollection ) {
    String userName = (String) principalCollection.getPrimaryPrincipal();

    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    if( "user".equals( userName ) ) {
      info.addRole( "user" );
    } else if( "admin".equals( userName ) ) {
      info.addRole( "admin" );
    } else if( "both".equals( userName ) ) {
      info.addRole( "user" );
      info.addRole( "admin" );
    }

    return info;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo( AuthenticationToken authToken )
      throws AuthenticationException {

    String userName = (String) authToken.getPrincipal();
    if( "user".equals( userName ) ) {
      return new SimpleAuthenticationInfo( "user", "user", getName() );
    } else if( "admin".equals( userName ) ) {
      return new SimpleAuthenticationInfo( "admin", "admin", getName() );
    } else if( "both".equals( userName ) ) {
      return new SimpleAuthenticationInfo( "both", "both", getName() );
    }

    throw new AuthenticationException();
  }

}