package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ApacheLibraryAccessors laccForApacheLibraryAccessors = new ApacheLibraryAccessors(owner);
    private final GoogleLibraryAccessors laccForGoogleLibraryAccessors = new GoogleLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final SerenityLibraryAccessors laccForSerenityLibraryAccessors = new SerenityLibraryAccessors(owner);
    private final Slf4jLibraryAccessors laccForSlf4jLibraryAccessors = new Slf4jLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for appiumClient (io.appium:java-client)
         * This dependency was declared in settings file 'settings.gradle'
         */
        public Provider<MinimalExternalModuleDependency> getAppiumClient() { return create("appiumClient"); }

        /**
         * Creates a dependency provider for assertj (org.assertj:assertj-core)
         * This dependency was declared in settings file 'settings.gradle'
         */
        public Provider<MinimalExternalModuleDependency> getAssertj() { return create("assertj"); }

        /**
         * Creates a dependency provider for awaitility (org.awaitility:awaitility)
         * This dependency was declared in settings file 'settings.gradle'
         */
        public Provider<MinimalExternalModuleDependency> getAwaitility() { return create("awaitility"); }

        /**
         * Creates a dependency provider for dotenv (io.github.cdimascio:dotenv-java)
         * This dependency was declared in settings file 'settings.gradle'
         */
        public Provider<MinimalExternalModuleDependency> getDotenv() { return create("dotenv"); }

        /**
         * Creates a dependency provider for faker (com.github.javafaker:javafaker)
         * This dependency was declared in settings file 'settings.gradle'
         */
        public Provider<MinimalExternalModuleDependency> getFaker() { return create("faker"); }

        /**
         * Creates a dependency provider for hamcrest (org.hamcrest:hamcrest-all)
         * This dependency was declared in settings file 'settings.gradle'
         */
        public Provider<MinimalExternalModuleDependency> getHamcrest() { return create("hamcrest"); }

        /**
         * Creates a dependency provider for lombok (org.projectlombok:lombok)
         * This dependency was declared in settings file 'settings.gradle'
         */
        public Provider<MinimalExternalModuleDependency> getLombok() { return create("lombok"); }

    /**
     * Returns the group of libraries at apache
     */
    public ApacheLibraryAccessors getApache() { return laccForApacheLibraryAccessors; }

    /**
     * Returns the group of libraries at google
     */
    public GoogleLibraryAccessors getGoogle() { return laccForGoogleLibraryAccessors; }

    /**
     * Returns the group of libraries at junit
     */
    public JunitLibraryAccessors getJunit() { return laccForJunitLibraryAccessors; }

    /**
     * Returns the group of libraries at serenity
     */
    public SerenityLibraryAccessors getSerenity() { return laccForSerenityLibraryAccessors; }

    /**
     * Returns the group of libraries at slf4j
     */
    public Slf4jLibraryAccessors getSlf4j() { return laccForSlf4jLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class ApacheLibraryAccessors extends SubDependencyFactory {

        public ApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for commons (org.apache.commons:commons-collections4)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getCommons() { return create("apache.commons"); }

            /**
             * Creates a dependency provider for maven (org.apache.maven.plugins:maven-surefire-plugin)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getMaven() { return create("apache.maven"); }

    }

    public static class GoogleLibraryAccessors extends SubDependencyFactory {

        public GoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (com.google.apis:google-api-services-sheets)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("google.api"); }

            /**
             * Creates a dependency provider for jetty (com.google.oauth-client:google-oauth-client-jetty)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getJetty() { return create("google.jetty"); }

            /**
             * Creates a dependency provider for oauth (com.google.oauth-client:google-oauth-client)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getOauth() { return create("google.oauth"); }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (junit:junit)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("junit.core"); }

            /**
             * Creates a dependency provider for jupiter (org.junit.jupiter:junit-jupiter)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getJupiter() { return create("junit.jupiter"); }

            /**
             * Creates a dependency provider for vintage (org.junit.vintage:junit-vintage-engine)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getVintage() { return create("junit.vintage"); }

    }

    public static class SerenityLibraryAccessors extends SubDependencyFactory {
        private final SerenityScreenplayLibraryAccessors laccForSerenityScreenplayLibraryAccessors = new SerenityScreenplayLibraryAccessors(owner);

        public SerenityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (net.serenity-bdd:serenity-core)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("serenity.core"); }

            /**
             * Creates a dependency provider for cucumber (net.serenity-bdd:serenity-cucumber)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getCucumber() { return create("serenity.cucumber"); }

            /**
             * Creates a dependency provider for ensure (net.serenity-bdd:serenity-ensure)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getEnsure() { return create("serenity.ensure"); }

            /**
             * Creates a dependency provider for junit (net.serenity-bdd:serenity-junit)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("serenity.junit"); }

            /**
             * Creates a dependency provider for junit5 (net.serenity-bdd:serenity-junit5)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getJunit5() { return create("serenity.junit5"); }

            /**
             * Creates a dependency provider for spring (net.serenity-bdd:serenity-spring)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getSpring() { return create("serenity.spring"); }

            /**
             * Creates a dependency provider for webdriver (net.serenity-bdd:serenity-screenplay-webdriver)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getWebdriver() { return create("serenity.webdriver"); }

        /**
         * Returns the group of libraries at serenity.screenplay
         */
        public SerenityScreenplayLibraryAccessors getScreenplay() { return laccForSerenityScreenplayLibraryAccessors; }

    }

    public static class SerenityScreenplayLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public SerenityScreenplayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for screenplay (net.serenity-bdd:serenity-screenplay)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("serenity.screenplay"); }

            /**
             * Creates a dependency provider for rest (net.serenity-bdd:serenity-screenplay-rest)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getRest() { return create("serenity.screenplay.rest"); }

    }

    public static class Slf4jLibraryAccessors extends SubDependencyFactory {

        public Slf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.slf4j:slf4j-api)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("slf4j.api"); }

            /**
             * Creates a dependency provider for simple (org.slf4j:slf4j-simple)
             * This dependency was declared in settings file 'settings.gradle'
             */
            public Provider<MinimalExternalModuleDependency> getSimple() { return create("slf4j.simple"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for apache which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.apache.maven.plugins:maven-surefire-plugin</li>
             *    <li>org.apache.commons:commons-collections4</li>
             * </ul>
             * This bundle was declared in settings file 'settings.gradle'
             */
            public Provider<ExternalModuleDependencyBundle> getApache() { return createBundle("apache"); }

            /**
             * Creates a dependency bundle provider for google which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.google.oauth-client:google-oauth-client</li>
             *    <li>com.google.oauth-client:google-oauth-client-jetty</li>
             *    <li>com.google.apis:google-api-services-sheets</li>
             * </ul>
             * This bundle was declared in settings file 'settings.gradle'
             */
            public Provider<ExternalModuleDependencyBundle> getGoogle() { return createBundle("google"); }

            /**
             * Creates a dependency bundle provider for junit which is an aggregate for the following dependencies:
             * <ul>
             *    <li>junit:junit</li>
             *    <li>org.junit.vintage:junit-vintage-engine</li>
             *    <li>org.junit.jupiter:junit-jupiter</li>
             * </ul>
             * This bundle was declared in settings file 'settings.gradle'
             */
            public Provider<ExternalModuleDependencyBundle> getJunit() { return createBundle("junit"); }

            /**
             * Creates a dependency bundle provider for serenity which is an aggregate for the following dependencies:
             * <ul>
             *    <li>net.serenity-bdd:serenity-core</li>
             *    <li>net.serenity-bdd:serenity-junit</li>
             *    <li>net.serenity-bdd:serenity-cucumber</li>
             *    <li>net.serenity-bdd:serenity-screenplay</li>
             *    <li>net.serenity-bdd:serenity-screenplay-rest</li>
             *    <li>net.serenity-bdd:serenity-ensure</li>
             *    <li>net.serenity-bdd:serenity-spring</li>
             *    <li>net.serenity-bdd:serenity-junit5</li>
             *    <li>net.serenity-bdd:serenity-screenplay-webdriver</li>
             * </ul>
             * This bundle was declared in settings file 'settings.gradle'
             */
            public Provider<ExternalModuleDependencyBundle> getSerenity() { return createBundle("serenity"); }

            /**
             * Creates a dependency bundle provider for slf4j which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.slf4j:slf4j-api</li>
             *    <li>org.slf4j:slf4j-simple</li>
             * </ul>
             * This bundle was declared in settings file 'settings.gradle'
             */
            public Provider<ExternalModuleDependencyBundle> getSlf4j() { return createBundle("slf4j"); }

            /**
             * Creates a dependency bundle provider for test which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.assertj:assertj-core</li>
             *    <li>org.hamcrest:hamcrest-all</li>
             *    <li>org.awaitility:awaitility</li>
             * </ul>
             * This bundle was declared in settings file 'settings.gradle'
             */
            public Provider<ExternalModuleDependencyBundle> getTest() { return createBundle("test"); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
