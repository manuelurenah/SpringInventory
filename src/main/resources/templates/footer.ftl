<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-inline">
                    <li>
                        <a href="/"><@spring.message "footer_home_msg" /></a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                <#if user??>
                    <li>
                        <a href="#"><@spring.message "profile_msg" /></a>
                    </li>
                <#else>
                    <li>
                        <a href="/user/login"><@spring.message "login_msg" /></a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="/user/create"><@spring.message "register_msg" /></a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>
                    <li>
                        <a href="?lang=en"><@spring.message "default_lang_msg" /></a> |
                        <a href="?lang=es"><@spring.message "spanish_lang_msg" /></a>
                    </li>
                </#if>
                </ul>
                <p class="copyright text-muted small">Copyright &copy; Luis E. Rojas | Manuel E. Ureña</p>
            </div>
        </div>
    </div>
</footer>
