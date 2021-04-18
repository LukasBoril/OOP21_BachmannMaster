package ch.zhaw.homework.le03.le03a.task6;


public interface ChangeRate
{
	/**
	 * gibt den Wechselkurs von Euro in SFR zurück
	 * @return
	 */
	public double getRate_EUROtoSFR();

	/**
	 * gibt den Wechselkurs von Euro in Euro zurück
	 * @return
	 */
	public double getRate_EUROtoEURO();

	/**
	 * gibt den Wechselkurs von Euro in Dollar zurück
	 * @return
	 */
	public double getRate_EUROtoDOLLAR();

	/**
	 * gibt den Wechselkurs von Euro in Britische Pfund zurück
	 * @return
	 */
	public double getRate_EUROtoPOUND();
}
